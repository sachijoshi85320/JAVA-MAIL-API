/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mailapiwork;

/**
 *
 * @author HP
 */
public class MailSendDemo {
    public static void main(String[] args) {
        try{
            TestSendMail.sendMail("reciever@gmail.com");            
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
}
