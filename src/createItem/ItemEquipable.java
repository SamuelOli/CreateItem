package createItem;


public class ItemEquipable extends Item {
    private MaterialType material;
    private RarityItem rarity;
    
     public ItemEquipable(){
         super();
         material = MaterialType.PEDRA;
         rarity = RarityItem.NORMAL;
         instantiatePower();
     }
     public ItemEquipable(String name, float initialPower){
         super(name, initialPower);
         material = MaterialType.PEDRA;
         rarity = RarityItem.NORMAL;
         instantiatePower();
     }
     public ItemEquipable(String name){
         super(name);
         material = MaterialType.PEDRA;
         rarity = RarityItem.NORMAL;
         instantiatePower();
     }
     public ItemEquipable(String name, float initialPower, MaterialType material, RarityItem rarity){
         super(name,initialPower);
         this.material = material;
         this.rarity = rarity;
         instantiatePower();
     }
     
     public void instantiatePower(){
         addPower(material.getPower());
         addPower(rarity.getPower());
     }
     
     public MaterialType getMaterialType(){
         return material;
     }
     public RarityItem getRarityItem(){
         return rarity;
     }
     
     public void setMaterial(MaterialType material){
         removePower(this.material.getPower());
         this.material = material;
         addPower(material.getPower());
     }
     
     public void setRarity(RarityItem rarity){
         removePower(this.rarity.getPower());
         this.rarity = rarity;
         addPower(rarity.getPower());
     }
     
     @Override
     public String desc(){
         return ("[ Nome do Item: " + getName() + "\nPoder Inicial: " + getInitialPower() + "\nPoder: " + getPower() + 
                 "\nMaterial: " + material.getMaterial() + ", " + material.getPower() +
                 "\nRaridade: " + rarity.getRarity() + ", " + rarity.getPower() +" ]");
     }
}
