public class Notebook {

    private String name;
    private String ram;
    private String hdd;
    private String os;
    private String color;
    private boolean isOn;

    /*Конструктор1*/
    public Notebook(String name, String ram, String hdd, String os, String color){
        this.name = name;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    /*Конструктор2*/
    public Notebook(){
        this.name = "";
        this.ram = "";
        this.hdd = "";
        this.os = "";
        this.color = "";

    }

    public String getName() {
        return name;
    }

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*Включить ноутбук*/
    public void turn_on(){
        if (!isOn) isOn = true;
    }

    /*Выключить ноутбук*/
    public void turn_of(){
        if (isOn) isOn = false;
    }

    /*Проверяем состояние (включен/выключен)*/
    public boolean is_isOn(){
        return isOn;
    }

    /*Изменяем объем ОЗУ*/
    public void change_ram(String ram){
        this.ram = ram;
        System.out.printf("Объем памяти ноутбука теперь %s Гигабайт", ram);
    }

    @Override
    public String toString() {
        return String.format("Model: %s, color: %s, RAM: %s Gb, HDD: %s Gb, OS: %s", name, color, ram, hdd, os);
    }
}
