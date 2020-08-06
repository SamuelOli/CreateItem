package createItem;

public enum RarityItem {
    NORMAL("Normal", 10),
    RARE("Rare", 40),
    EPIC("Epic", 100);
    
    private String rarity;
    private float power;
    
    RarityItem(String rarity, float power){
        this.rarity = rarity;
        this.power = power;
    }
    
    public String getRarity(){
        return rarity;
    }
    public float getPower(){
        return power;
    }
}
