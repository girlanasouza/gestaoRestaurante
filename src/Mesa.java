public class Mesa {
    private int id;
    private int numberTable;
    private String avaliableTable; // Se a mesa está disponível ("true") ou não disponível ("false")

    public Mesa() {
        this.id = 0;
        this.numberTable = 0;
        this.avaliableTable = "false";
    }

    public Mesa(int id, int numberTable, String avaliableTable) {
        this.id = id;
        this.numberTable = numberTable;
        this.avaliableTable = avaliableTable;
    }

    public boolean verifyAvaliableTable() {
        return avaliableTable.equalsIgnoreCase("true");
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void mesaDisponivel() {
        setAvaliableTable("true");
    }

    public void setNumberTable(int numberTable) {
        this.numberTable = numberTable;
    }

    public void setAvaliableTable(String avaliableTable) {
        this.avaliableTable = avaliableTable;
    }

    public int getNumberTable() {
        return this.numberTable;
    }

    public String getAvaliableTable() {
        return this.avaliableTable;
    }

    public String verify() {
        if (getAvaliableTable().equalsIgnoreCase("true")) {
            return ", mesa disponível";
        }
        return ", mesa não disponível";
    }

    public String toString() {
        String retorno = "Número de mesa: " + getNumberTable() + "\n" + verify() + "\n";
        return retorno;
    }
}
