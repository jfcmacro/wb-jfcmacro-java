public class IsValidUnixPath {

    private static boolean isUnixPathWellFormed(String path) {
        return true && !path.matches("(.*~.*)(.*~.*)+") &&
            !path.matches(".+~.*") &&
            !path.matches(".*\\\\.*") &&
            !path.matches("((.*~.*/.*)|(,*/.*~,*))+") &&
            !path.matches("((.*\\\\.*/.*)|(.*/.*\\\\.*))+");
    }

    

    public static void main(String[] args) {
        String[] valid = { "/this/is/valid.txt",
                           "~/./../../../valid.txt",
                           "../../valid.txt" };

        String[] invalid = {
                "/folder1/folder2\\folder3",
                "/dev/~/",
                "C:/a/b/c///d",
                "~\\folder",
                "~/~",
                "~~"
        };

        for (String v : valid) {
            System.out.printf("str: %s isValid: %s%n",
                              v, isUnixPathWellFormed(v));
        }

        for (String i : invalid) {
            System.out.printf("str: %s isInvalid: %s%n",
                              i, !isUnixPathWellFormed(i));
        }
    }
}
