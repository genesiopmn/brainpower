package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.dto.AccountDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.factory.AccountFactory;
import br.com.brainpower.bluebank.factory.ClientFactory;
import br.com.brainpower.bluebank.form.AccountForm;
import br.com.brainpower.bluebank.repository.AccountRepository;
import br.com.brainpower.bluebank.repository.ClientRepository;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe com a regra de negócio para a conta
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    /**
     * Lógica para trazer todas as contas.
     * @return retorna uma lista de clientDto
     */

    public List<AccountDto> findAll(){
        List<Account> listAccount = accountRepository.findAll();
        List<AccountDto> listAccountDto = new ArrayList<>();
        for(Account account : listAccount){
            int idClient = account.getClient().getId();
            Optional<Client> clientOptional = clientRepository.findById(idClient);
            if(!clientOptional.isEmpty() && clientOptional.get().isActive() && account.getAccountStatus() == true && account.isActive()){
                Client client = clientOptional.get();
                ClientDto clientDto = ClientFactory.convertClientDto(client);
                AccountDto accountDto = AccountFactory.convertAccountDto(account);
                accountDto.setClient(clientDto);
                clientDto.addListAccountDto(accountDto);
                listAccountDto.add(accountDto);
            }         
            
        }
        
        return listAccountDto;
    }

    /**
     * Função que busca a conta por id.
     * @param id - Id para buscar a conta
     * @return retorna um objeto do tipo ContaDto
     */
    public AccountDto findById(Integer id){
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        if(!AccountFactory.checkStatus(accountOptional.get())){
            throw new ResourceNotFoundException("id not found");
        }
        if(!accountOptional.get().getAccountStatus()){
            throw new ResourceNotFoundException("id not found");    
        }
        Account account = accountOptional.get();
        Optional<Client> clientOptional = clientRepository.findById(account.getClient().getId());
        if(clientOptional.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        if(!ClientFactory.checkStatus(clientOptional.get())){
            throw new ResourceNotFoundException("id not found");
        }
        AccountDto accountDto = null;
        if(!clientOptional.isEmpty() && clientOptional.get().isActive() && account.getAccountStatus() == true && account.isActive()) {
            Client client = clientOptional.get();
            ClientDto clientDto = ClientFactory.convertClientDto(client);
            accountDto = AccountFactory.convertAccountDto(account);
            clientDto.addListAccountDto(accountDto);
            accountDto.setClient(clientDto);
        }    
        return accountDto; 
    }

    /**
     * Função com objeto de buscar a conta pelo o documento de identificação do cliente
     * @param identificationDocument - recebe um documento de identificação do cliente
     * @return retorna um objeto do tipo Account Dto
     */
    public AccountDto findAllByIdentificationDocument(String identificationDocument){
        Account account = accountRepository.findByidentificationDocument(identificationDocument);
        if(account == null){
            throw new ResourceNotFoundException("id not found");    
        } 
        if(!AccountFactory.checkStatus(account)){
            throw new ResourceNotFoundException("id not found");     
        }
        if(!account.isActive()){
            throw new ResourceNotFoundException("Account not Active");
        }
        return AccountFactory.convertAccountDto(account);
    }

    /**
     * Desabilita uma conta para não se utilizavel
     * @param id - Recebe um id para desabilita a conta com esse id
     */
    public void disableAccountById(Integer id){
        Optional<Account> accountOptional = accountRepository.findById(id);
        Account account = accountOptional.get();
        if(accountOptional.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        if(!AccountFactory.checkStatus(account)){
            throw new ResourceNotFoundException("id not found");    
        }
        account.setAccountStatus(false);
        accountRepository.save(account);
    }

    /**
     * Função que reativa uma conta passando por id
     * @param id - id da conta que precisa ser reativado
     */
    public void reactivateAccountById(Integer id){
        Optional<Account> accountOptional = accountRepository.findById(id);
        Account account = accountOptional.get();
        if(accountOptional.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        if(!AccountFactory.checkStatus(account)){
            throw new ResourceNotFoundException("id not found");
        }
        account.setAccountStatus(true);
        accountRepository.save(account);
    }

    /**
     * Função que salva a conta no banco de dados
     * @param accountForm - formulário com os campos que precisa 
     * @return retorno da Conta Dto salva no banco de dados
     */
    public AccountDto saveAccount(AccountForm accountForm){
        var client = getClientById(accountForm.getClient());
        Account account = AccountFactory.convertAccountForm(accountForm, client);
        accountRepository.save(account);
        return AccountFactory.convertAccountDto(account);
    }

    /**
     * Remove uma conta pelo o ID
     * @param id - Id da conta para ser excluída.
     */
    public void removeById(Integer id){
        try
        {
            accountRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e)
        {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            Account account = accountRepository.findById(id).get();
            AccountFactory.disableStatus(account);
            accountRepository.save(account);
        }
    }

    public Client getClientById(Integer id){

        var client =  clientRepository.findById(id);

        if(client.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        if(!ClientFactory.checkStatus(client.get())){
            throw new ResourceNotFoundException("client is not active");
        }

        return client.get();

    }
}
