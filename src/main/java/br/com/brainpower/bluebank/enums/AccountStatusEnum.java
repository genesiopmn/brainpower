package br.com.brainpower.bluebank.enums;


public enum AccountStatusEnum {

    ACTIVE(1),
    INACTIVE(2);
    
    private int value;

    AccountStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AccountStatusEnum toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(AccountStatusEnum accountStatusEnum : AccountStatusEnum.values()){
            if(cod.equals(accountStatusEnum.getValue())){
                return accountStatusEnum;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + cod);
    }
}
