package fifthweek;

import java.util.*;

public class AccountsMerge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Account> map = new HashMap<>();
        List<List<String>> mergedAccounts = new ArrayList<>();

        for (List<String> info : accounts) {
            Account aux = new Account(info);
            aux.registerAccount(map);
        }

        Set<Account> uniqueAccounts = new HashSet<>(map.values());
        for (Account account : uniqueAccounts) {
            mergedAccounts.add(account.getAccountInfo());
        }
        return mergedAccounts;
    }
}

class Account {

    private Set<String> emails;
    private String name;

    public Account(List<String> info) {
        name = info.getFirst();
        emails = new HashSet<>();
        for (int i = 1; i < info.size(); i++) {
            emails.add(info.get(i));
        }
    }

    public boolean addEmail(String email) {
        return emails.add(email);
    }

    public void mergeAccount(Account account) {
        if (account == this) {
            return;
        }

        for (String email : account.emails) {
            addEmail(email);
        }
    }

    public void registerAccount(Map<String, Account> accountMap) {
        Queue<String> queue = new ArrayDeque<>(emails);

        while (!queue.isEmpty()) {
            String email = queue.poll();
            if (accountMap.containsKey(email)) {
                mergeAccount(accountMap.get(email));
                accountMap.remove(email);
            }
        }

        for (String email : emails) {
            accountMap.put(email, this);
        }

    }

    public List<String> getAccountInfo() {
        List<String> info = new ArrayList<>(emails);
        Collections.sort(info);
        info.addFirst(name);
        return info;
    }
}
