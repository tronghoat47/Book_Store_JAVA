/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import dal.DAOBook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TrongHoa
 */
public  class Cart {
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    
    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }
    
    private Item getItemById(int id) {
        for (Item i : items) {
            if(i.getBook().getBookID()==id)
                return i;
        }
        return null;
    }
    
    public void addItem(Item t) {
        if(getItemById(t.getBook().getBookID())!=null) {
            Item m = getItemById(t.getBook().getBookID());
            m.setQuantity(m.getQuantity()+t.getQuantity());
        }else {
            items.add(t);
        }
    }
    
    public void removeItem(int id) {
        if(getItemById(id)!=null) {
            items.remove(getItemById(id));
        }
    }
    
    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t+=(i.getQuantity()*i.getPrice());
        }
        return t;
    }
    
    private Book getProductById(int id, List<Book> list) {
        for (Book i : list) {
            if(i.getBookID()==id)
                return i;
        }
        return null;
    }
    
    public Cart(String txt, List<Book> list) {
        items = new ArrayList<>();
        try{
        if(txt!=null && txt.length()!=0) {
            String[] s  = txt.split("/");
            for (String i : s) {
                String[] n=i.split(":");
                int id=Integer.parseInt(n[0]);
                int quantity = Integer.parseInt(n[1]);
                Book b = getProductById(id, list);
                Item t = new Item(b, quantity, b.getPrice() - b.getPrice()*b.getDiscount()/100);
                addItem(t);
            }
        }
        }catch (NumberFormatException e) {
            
        }
    }

    
}
