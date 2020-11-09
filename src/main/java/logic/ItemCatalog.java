package logic;

import java.util.List;

import model.Item;

public interface ItemCatalog {
   void putItem(Item item);//상품등록
   List<Item> getItems(Integer pageNo);//상품목록
   Integer getItemCount();//상품 갯수
   Item getItem(String code);//상품상제
}