package createItem;

import javax.swing.JOptionPane;

public class Item {
    private String name;
    private float initialPower;
    private float power;
    
    public Item(){
        name = "";
        initialPower = 0;
        power = 0;
    }
    public Item(String name, float initialPower){
        setName(name);
        setInitialPower(initialPower);
        setPower(initialPower);
    }
    public Item(String name){
        setName(name);
        setInitialPower(0);
        setPower(0);
    }
    
    
    
    public void setName(String newName){
        if(newName!= null && !newName.isEmpty()){
            name = newName;
        }
    }
    
    public void addPower(float add){
        power += add;
    }
    public void removePower(float remove){
        power -= remove;
        if(power < 0){
            power = 0;
        }
    }
    public void setInitialPower(float initialPower){
        if(initialPower >= 0){
            this.initialPower = initialPower;
        }
    }
    public void setPower(float power){
        if(power >= 0){
            this.power = power;
        }
    }
    
    public String getName(){
        return name;
    }
    public float getInitialPower(){
        return initialPower;
    }
    public float getPower(){
        return power;
    }
    
    public String desc(){
         return ("[ Nome do Item: " + getName() + "\nPoder Inicial: " + getInitialPower() + "\nPoder: " + getPower() + " ]");
     }
    
    public void impConsole(){
        System.out.println(desc());
    }
    public void impInterface(){
        JOptionPane.showMessageDialog(null,desc());
    }
}
