public class Phone extends Hardware {

    public Phone(int id, String brand, int spec) {
        super(id, brand, spec, "Phone");
    }

    @Override
    public String interpretSpec() {
        return getSpec() + " Megapixels";
    }
}
