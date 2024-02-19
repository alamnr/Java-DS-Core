package org.myproject.concatenate;

public  class EnumType{


    public enum Company {
        EBAY, PAYPAL, GOOGLE, YAHOO, ATT
    }
    Company cName;
    public EnumType(Company cName) {
        this.cName = cName;
    }
    public void companyDetails() {
        switch (cName) {
            case EBAY:
                System.out.println("EBAY: Biggest Market Place in the World.");
                break;
            case PAYPAL:
                System.out.println("PAYPAL: Simplest way to manage Money.");
                break;
            case GOOGLE:
            case YAHOO:
                System.out.println("YAHOO: 1st Web 2.0 Company.");
                break;
            default:
                System.out.println("DEFAULT: Google - biggest search giant.. ATT - my carrier provider..");
                break;
        }
    }
    public static void main(String[] args) {
        EnumType ebay = new EnumType(Company.EBAY);
        ebay.companyDetails();
        EnumType paypal = new EnumType(Company.PAYPAL);
        paypal.companyDetails();
        EnumType google = new EnumType(Company.GOOGLE);
        google.companyDetails();
        EnumType yahoo = new EnumType(Company.YAHOO);
        yahoo.companyDetails();
        EnumType att = new EnumType(Company.ATT);
        att.companyDetails();
    }
}

