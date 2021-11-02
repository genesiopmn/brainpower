package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.enums.AccountStatusEnum;
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
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<AccountDto> findAll(){
        List<Account> listAccount = accountRepository.findAll();
        List<AccountDto> listAccountDto = new ArrayList<>();
        for(Account account : listAccount){
            int idClient = account.getClient().getId();
            Client client = clientRepository.findById(idClient).get();
            ClientDto clientDto = ClientFactory.convertClientDto(client);
            AccountDto accountDto = AccountFactory.convertAccountDto(account);
            accountDto.setClient(clientDto);
            clientDto.addListAccountDto(accountDto);
            listAccountDto.add(accountDto);
        }
        
        return listAccountDto;
    }

    public AccountDto findById(Integer id){
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        if(!AccountFactory.checkStatus(accountOptional.get())){
            throw new ResourceNotFoundException("id not found");
        }
        Account account = accountOptional.get();
        Optional<Client> clientOptional = clientRepository.findById(account.getId());
        if(clientOptional.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        if(!ClientFactory.checkStatus(clientOptional.get())){
            throw new ResourceNotFoundException("id not found");
        }
        Client client = clientOptional.get();
        ClientDto clientDto = ClientFactory.convertClientDto(client);
        AccountDto accountDto = AccountFactory.convertAccountDto(account);
        clientDto.addListAccountDto(accountDto);
        accountDto.setClient(clientDto);
        return accountDto; 
    }

    public List<AccountDto> findAllByIdClient(Integer id){
        //talvez o ideal aqui fosse buscar por cpf/doc de identificação
        Client client = clientRepository.findById(id).get();
        return accountRepository.findAllByClient(client).stream().map(AccountFactory::convertAccountDto).collect(Collectors.toList());
    }

    public void disableAccountById(Integer id){
        var account = findById(id);
        account.setAccountStatus(AccountStatusEnum.INACTIVE);
    }

    public void reactivateAccountById(Integer id){
        var account = findById(id);
        account.setAccountStatus(AccountStatusEnum.ACTIVE);
    }

    public AccountDto saveAccount(AccountForm accountForm){
        Account account = AccountFactory.convertAccountForm(accountForm);
        accountRepository.save(account);
        return AccountFactory.convertAccountDto(account);
    }

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
}
