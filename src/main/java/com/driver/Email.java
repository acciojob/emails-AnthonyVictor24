package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character.
//        boolean upperCase=false;
//        boolean lowerCase=false;
//        boolean digit=false;
//        boolean specialChar=false;
//        if(password.equals(oldPassword)){
//            if(newPassword.length()>=8){
//                boolean upperCase=false;
//                boolean lowerCase=false;
//                boolean digit=false;
//                boolean specialChar=false;
//                for(int i=0;i<newPassword.length();i++){
//                    char ch = newPassword.charAt(i);
//                    if(!upperCase){
//                        if(ch>='A' && ch<='Z'){
//                            upperCase=true;
//                        }
//                    }
//                    else if(!lowerCase){
//                        if(ch>='a' && ch<='z'){
//                            lowerCase=true;
//                        }
//                    }
//                    else if(!digit){
//                        if(ch>='0' && ch<='9'){
//                            digit=true;
//                        }
//                    }
//                    else if(!specialChar){
//                        if(!Character.isLetterOrDigit(ch)){
//                            specialChar = true;
//                        }
//                    }
//                }
//                if(upperCase && lowerCase && digit && specialChar){
//                    this.password=newPassword;
//                    System.out.println("Password changed successfully");
//                }else{
//                    System.out.println("Please follow the requirements");
//                }
//            }else{
//                System.out.println("Password length should be atleast 8 characters");
//            }
//        }else{
//            System.out.println("Passwords did not matched");
//        }
        if(password.equals(oldPassword)){
            if(newPassword.length() >= 8){
                boolean upperCase = false;
                boolean lowerCase = false;
                boolean digit = false;
                boolean specialChar = false;

                for(int i = 0; i < newPassword.length(); i++){
                    char ch = newPassword.charAt(i);
                    if(!upperCase){
                        if(ch >= 'A' && ch <= 'Z'){
//                            System.out.println("UpperCase");
                            upperCase = true;
                        }
                    }
                    if(!lowerCase){
                         if(ch >= 'a' && ch <= 'z'){
//                            System.out.println("LowerCase");
                            lowerCase = true;
                        }
                    }
                    if(!digit){
                        if(ch >= '0' && ch <= '9'){
//                            System.out.println("Digit");
                            digit = true;
                        }
                    }
                    if(!specialChar){
                        if(!Character.isLetterOrDigit(ch)){
//                            System.out.println("Special");
                            specialChar = true;
                        }
                    }

                }

                if(upperCase && lowerCase && digit && specialChar){
                    this.password = newPassword;
//                    System.out.println("Password changed successfully");
                }
            }
        }
    }
}

