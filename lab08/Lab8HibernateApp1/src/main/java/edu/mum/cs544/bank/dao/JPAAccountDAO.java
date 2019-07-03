package edu.mum.cs544.bank.dao;

import java.util.*;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import edu.mum.cs544.bank.EntityManagerHelper;
import edu.mum.cs544.bank.domain.Account;

public class JPAAccountDAO implements IAccountDAO {

  private EntityManager em() {
    return EntityManagerHelper.getCurrent();
  }

  public void saveAccount(Account account) {
    em().persist(account);
  }

  public void updateAccount(Account account) {
    em().merge(account);

  }

  public Account loadAccount(long accountnumber) {

    return em().find(Account.class, accountnumber);
  }

  public Collection<Account> getAccounts() {
    EntityGraph<Account> g = em().createEntityGraph(Account.class);
    g.addAttributeNodes("entryList");
    g.addAttributeNodes("customer");
    return em().createQuery("from Account", Account.class).setHint("javax.persistence.fetchgraph", g).getResultList();

    // return em().createQuery("select distinct a from Account a JOIN FETCH a.entryList", Account.class).getResultList();
  }

}
