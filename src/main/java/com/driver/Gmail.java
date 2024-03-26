package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    ArrayList<Mail> InboxMailsList;
    ArrayList<TrashMail> trashList;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        this.InboxMailsList=new ArrayList<>();
        this.trashList=new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
//        if(InboxMailsList.size()<inboxCapacity){
//            InboxMailsList.add(new Mail(date, sender, message));
//            System.out.println(InboxMailsList.size());
//            for(Mail m : InboxMailsList){
//                System.out.println(m);
//            }
//        }else{
//            Mail mail = InboxMailsList.remove(0);
//            Date date1 = mail.getDate();
//            String sender1 = mail.getSender();
//            String message1 = mail.getMessage();
//            trashList.add(new TrashMail(date1,sender1,message1));
//        }

        if(InboxMailsList.size()>=inboxCapacity){
            Mail mail = InboxMailsList.remove(0);
            trashList.add(new TrashMail(mail.getDate(),mail.getSender(),mail.getMessage()));
            InboxMailsList.add(new Mail(date, sender, message));
        }else{
            InboxMailsList.add(new Mail(date, sender, message));
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i=0;i<InboxMailsList.size();i++){
            if(InboxMailsList.get(i).getMessage().equals(message)){
                Mail mail = InboxMailsList.remove(i);
                Date date1 = mail.getDate();
                String sender1 = mail.getSender();
                String message1 = mail.getMessage();
                trashList.add(new TrashMail(date1,sender1,message1));
//                InboxMailsList.remove(i);
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(InboxMailsList.isEmpty()){
            return null;
        }else{
            return InboxMailsList.get(InboxMailsList.size()-1).getMessage();
        }
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(InboxMailsList.isEmpty()){
            return null;
        }else{
            return InboxMailsList.get(0).getMessage();
        }
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;
        for(int i=0;i<InboxMailsList.size();i++){
            Mail mail = InboxMailsList.get(i);
            if(mail.getDate().compareTo(start)>=0 && mail.getDate().compareTo(end)<=0){
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return InboxMailsList.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trashList.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
//        for(int i=0;i<trashList.size();i++){
//            trashList.remove(i);
//        }
        trashList.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }


}

