package createItem;

public enum MaterialType {
    MADEIRA("Madeira",10),
    PEDRA("Pedra", 20),
    FERRO("Ferro", 30);
    
    private String material;
    private float power;
    
    MaterialType(String material, float power){
        this.material = material;
        this.power = power;
    }
    
    public String getMaterial(){
        return material;
    }
    public float getPower(){
        return power;
    }
}
