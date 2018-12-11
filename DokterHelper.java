/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Dokter;
import util.NewHibernateUtil;

/**
 *
 * @author yosri
 */
public class DokterHelper {
    public DokterHelper() {
    }

    public List<Dokter> getDokter(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Dokter> list = null;
        Query q = session.createQuery("from Dokter d");
        list = q.list();
        tx.commit();
        session.close();
        return list;
    }
    public void addNewDokter(String nama, String spesialis){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Dokter dokter = new Dokter(nama,spesialis);
        session.saveOrUpdate(dokter);
        transaction.commit();
        session.close();
    }
    public static String toJson(){
        DokterHelper helper = new DokterHelper();
        List<Dokter> list = helper.getDokter();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < (list.size() - 1)) {
                result += list.get(i).toJson() + ", \n";
            } else {
                result += list.get(i).toJson();
            }
        }
        result+="]";
        return result;
    }
}
