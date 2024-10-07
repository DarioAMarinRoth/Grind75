package secondweek;

public class FirstBadVersion {

    private final boolean[] versions;

    public FirstBadVersion() {
        int n = 2126753390;
        int bad = 1702766719 - 1;
        versions = new boolean[n];

        for (int i = 0; i < n; i++) {
            versions[i] = !(i < bad);
        }
    }

    public int firstBadVersion(int n) {

        if (isBadVersion(1)) {
            return 1;
        }

        if (isBadVersion(n) && !isBadVersion(n - 1)) {
            return n;
        }

        int index = n / 2;
        int left = 1;
        int right = n;

        while (true) {
            if (isBadVersion(index)) {
                if (!isBadVersion(index - 1)) {
                    return index;
                } else {
                    right = index;
                }
            } else {
                if (isBadVersion(index + 1)) {
                    return index + 1;
                }
                left = index;
            }
            index = (int)((((long) right) + ((long) left)) / 2) ;
        }
    }

    public boolean isBadVersion(int version) {
        return versions[version - 1];
    }

}
