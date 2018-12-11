/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.User;
import util.NewHibernateUtil;

/**
 *
 * @author yosri
 */
public class UserHelper {
    
    public UserHelper() {
    }

    public List<User> getAllUser() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<User> hasil = null;
        Query q = session.createQuery("from User u");
        hasil = q.list();
        tx.commit();
        session.close();
        return hasil;
    }

    public User getUser(String username, String password) {
        List<User> list = this.getAllUser();
        User user = new User(username, password);
        int index = -1;
        if (list.size() > -1) {
            for (int i = 0; i < list.size(); i++) {
                if (username.equals(list.get(i).getEmail())) {
                    index = i;
                }
            }
        } else {
            index = -1;
        }

        if (index < 0) {
            System.out.println("User tidak ada");
            return null;
        } else {
            // user ada
            User result = list.get(index);
            System.out.println("Pencarian = " + result.getEmail() + "," + result.getPassword());
            if (password.equals(result.getPassword())) {
                System.out.println("Email: " + user.getEmail() + "\nPassword: " + user.getPassword());
                return user;
            } else {
                System.out.println("pass salah");
                // pass salah
                return null;
            }
        }
    }

    public static String toJson() {
        UserHelper helper = new UserHelper();
        List<User> list = helper.getAllUser();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < (list.size() - 1)) {
                result += list.get(i).toJson() + ", \n";
            } else {
                result += list.get(i).toJson();
            }
        }
        result += "]";
        return result;
    }
}
