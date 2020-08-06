package createItem;


public class ItemConsumable extends Item {
    private int stack;
    
     public ItemConsumable(){
        super();
        stack = 0;
    }
    public ItemConsumable(String name, float initialPower){
        super(name, initialPower);
        stack = 0;
    }
    public ItemConsumable(String name){
        super(name);
        stack = 0;
    }
    public ItemConsumable(String name, int stack){
        super(name);
        setStack(stack);
    }
    public ItemConsumable(String name, float initialPower, int stack){
        super(name,initialPower);
        setStack(stack);
    }
    
    public void setStack(int stack){
        if(stack >= 0){
            this.stack = stack;
        }
    }
    
    public int getStack(){
        return stack;
    }
    
    public void useItem(int i){
        if(stack > i){
            stack -= i;
        }
    }
    
    @Override
     public String desc(){
         return ("[ Nome do Item: " + getName() + "\nPoder Inicial: " + getInitialPower() + "\nPoder: " + getPower() +
                 "\nQuantidade: " + getStack() + " ]");
     }
                 
                 
}
