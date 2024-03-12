import java.util.Scanner;

// MEMBUAT APLIKASI TODOLIST
// 1. Buat array penampung Todo
// 2. Buat inputan mengguanakan Scanner
// 3. Tentukan logic data(repository) add dan remove
// 4. Tentukan logic busisness(service) show, add dan remove
// 5. Testing tiap method service
// 6. Buat view untuk memanggil setiap method
public class aplikasiTodoList {
    private static String[] data = new String[10];
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        testShowTodolist();
//        testAddtodolist();
//        testRemoveTodolist();
        viewShowTodolist();
//        viewAddTodolist();
//        showTodolist();
//        viewRemoveTodolist();
//        showTodolist();
    }
    public static void showTodolist(){
        for(var i=0; i< data.length; i++){
            var no = i+1;
            var todo = data[i];
            if(todo!= null){
                System.out.println(no + ". "+ todo);
            }
        }
    }
    public static void testShowTodolist(){
        data[0] = "Bermain";
        data[1] = "Belajar";
        showTodolist();
    }
    public static boolean isFull(){
        var isFull = true;
        for(var i=0; i< data.length; i++){
            if(data[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    public static void resizeIfFull(){
        if(isFull()){
            var temp = data;
            data = new String[data.length*2];
            for(var i=0; i<temp.length; i++){
                data[i] = temp[i];
            }
        }
    }
    public static void addTodolist(String todo){
        resizeIfFull();
        for(var i =0; i< data.length; i++){
            if(data[i] == null){
                data[i] = todo;
                break;
            }
        }
    }
    public static void testAddtodolist(){
        for(var i= 0; i<100; i++){
            addTodolist("Bermain");
        }
        showTodolist();
    }
    public static boolean removeTodolist(Integer number){
        if((number-1) >= data.length){
            return false;
        } else if (data[number-1] == null) {
            return false;
        } else {
            for(var i=(number-1); i< data.length; i++){
                if(i == (data.length-1)){
                    data[i] = null;
                }else {
                    data[i] = data[i+1];
                }
            }
        }
        return true;
    }
    public static void testRemoveTodolist(){
        addTodolist("Bekerja");
        addTodolist("Belanja");
        showTodolist();
        removeTodolist(1);
        showTodolist();
    }
    public static String input(String info){
        System.out.print(info + ": ");
        var dataInput = scanner.nextLine();
        return dataInput;
    }
    public static void viewShowTodolist() {
        while (true) {
            showTodolist();
            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
            var inputan = input("Pilih ");

            if (inputan.equals("1")) {
                viewAddTodolist();
            } else if (inputan.equals("2")) {
                viewRemoveTodolist();
            } else if (inputan.equals("x")) {
                break;
            } else {
                System.out.println("Tidak Dimengerti");
            }
        }
    }
    public static void viewAddTodolist(){
        System.out.println("TAMBAH DATA");
        var inputan = input("Input todo(x jika keluar)");
        if(inputan.equals("x")){
//
        }else {
            addTodolist(inputan);
        }
    }
    public static void viewRemoveTodolist(){
        System.out.println("HAPUS DATA");
        var inputan = input("Hapus todo(x jika keluar)");
        if(inputan.equals("x")){
//
        }else {
            boolean success = removeTodolist(Integer.valueOf(inputan));
            if(success){
                System.out.println("Data berhasil dihapus");
            }else {
                System.out.println("Data gagal dihapus");
            }
        }
    }
}
