public class SingleFormat {
    private String name;
    private String [] magicNumber;
    private long offset;

    public  SingleFormat(String name, String [] magicNumber, long offset) {
        this.name = name;
        this.magicNumber = magicNumber;
        this.offset = offset;
    }

    public String getName() {
        return this.name;
    }

    public String [] getMagicNumber() {
        return this.magicNumber;
    }

    public  long getOffset() {
        return this.offset;
    }
}
