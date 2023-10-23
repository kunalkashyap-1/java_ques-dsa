package DSA_sheet.string;

public class LongestPrefixSuffix {
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);
    }

    static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        int[] lps = computeLPSArray(pat, M);
        int j = 0;
        int i = 0;

        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at :-" + (i - j));
                j = lps[j - 1];
            }
            //mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else i++;
            }
        }
    }

    static int[] computeLPSArray(String pat, int M) {
        int[] res = new int[M];
        int len = 0;
        int i = 1;
        res[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                res[i] = len;
                i++;
            } else //pat[i] != pat[len]]
            {
                if (len != 0) {
                    len = res[len - 1];
                } else {//if len = 0
                    res[i] = len;
                    i++;
                }
            }
        }
        return res;
    }
}
