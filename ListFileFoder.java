import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ListFileFoder {
    public static void directoryTree(String path) throws IOException {
        File dir = new File(path);
        // kiểm tra file or folder tồn tại ko
        if (dir.exists()) {
            System.out.println("Folder " + path + "does not exits ");
        }
        //kiểm tra có phải thư mục ko
        if (dir.isDirectory()) {
            File[] list = dir.listFiles();//listFiles lấy danh sách file hay thư mục trong thư mục
            //đ/k dừng đệ quy
            if (list != null) {
                for (File file : list) {
                    System.out.println(file.getCanonicalPath());//lấy đường dẫn file hay folder
                    directoryTree(file.getCanonicalPath());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("The program shows the directory tree");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path of the directory: ");

        String path = scanner.nextLine();

        directoryTree(path);
    }
}
