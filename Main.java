import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Lenovo Ideapad", "16", "512", "Ubuntu Linux", "Grey"));
        notebooks.add(new Notebook("Asus Zenmate", "4", "128", "DOS", "Black"));
        notebooks.add(new Notebook("HP Probook", "8", "256", "Windows 10", "Silver"));
        notebooks.add(new Notebook("Dell Vostro", "16", "256", "Windows 11", "White"));
        notebooks.add(new Notebook("Alienware", "32", "1024", "Windows 11", "Black"));
        notebooks.add(new Notebook("Huawei", "16", "512", "Windows 10", "Silver"));
        notebooks.add(new Notebook("Acer Aspire", "8", "128", "DOS", "Red"));

        for (Notebook nb: notebooks){
            System.out.println(nb.toString());
        }
        System.out.println("------------------------------");
        Map<String, String> filter = getfilter();
        List<Notebook> filteredlist = filter(filter, notebooks);
        for (Notebook nb: filteredlist){
            System.out.println(nb.toString());
        }
    }

    public static Map<String, String> getfilter(){
        Scanner scn = new Scanner(System.in);
        String ram = "";
        String hdd = "";
        String os = "";
        Map<String, String> res = new HashMap<>();
        System.out.print("Введите объем оперативной памяти (4, 8, 16 и т.д.): ");
        ram = scn.nextLine();
        res.put("ram", ram);
        System.out.println();
        System.out.print("Введите объем диска (64, 128 т.д.): ");
        hdd = scn.nextLine();
        res.put("hdd", hdd);
        System.out.println();
        System.out.print("Введите название установленной ОС (Windows, Linux и т.д.): ");
        os = scn.nextLine();
        res.put("os", os);
        return res;
    }

    public static List<Notebook> filter(Map<String, String> params, List<Notebook> notebooks){
        List<Notebook> res = new ArrayList<>();
        boolean isram = false;
        boolean ishdd = false;
        boolean isos  = false;
        int ram = 0;
        int hdd = 0;
        String os = "0";
        String tmp = "";
        for (Map.Entry<String, String> val: params.entrySet()) {
            tmp = val.getKey();
            switch (tmp) {
                case ("ram"):
                    if (!val.getValue().isEmpty()) {
                        ram = Integer.parseInt(val.getValue());
                        break;
                    } else{
                        ram = 0;
                        break;
                    }
                case ("hdd"):
                    if (!val.getValue().isEmpty()) {
                        hdd = Integer.parseInt(val.getValue());
                        break;
                    } else{
                        hdd = 0;
                        break;
                    }
                case ("os"):
                    if (!val.getValue().isEmpty()) {
                        os = val.getValue();
                        break;
                    } else{
                        os = "";
                        break;
                    }
            }
        }
        for (Notebook nb: notebooks){
            if (ram == Integer.parseInt(nb.getRam()) || ram == 0){
                isram = true;
            }
            if (hdd == Integer.parseInt(nb.getHdd()) || hdd == 0){
                ishdd = true;
            }
            if (nb.getOs().toLowerCase().contains(os.toLowerCase()) || os == ""){
                isos = true;
            }
            if (isram && ishdd && isos){
                res.add(nb);
                isram = false;
                ishdd = false;
                isos = false;
            }
        }

        return res;
    }

}