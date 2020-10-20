package model;

import java.sql.Timestamp;

public class SaleDetail {
   private Integer saleId;
   private Integer itemId;
   private Sale sale;
   private Item item;
   private String updateTime;
   private Integer quantity;
   private Integer saleDetailId;

   public SaleDetail(Sale sale, Integer saleLineId, ItemSet itemSet, Timestamp currentTime) {
      this.sale = sale;
      this.saleDetailId = saleLineId;
      this.item = itemSet.getItem();
      this.quantity = itemSet.getQuantity();
      this.updateTime = String.valueOf(currentTime);
   }

   public Integer getSaleId() {
      return saleId;
   }

   public void setSaleId(Integer saleId) {
      this.saleId = saleId;
   }

   public Integer getItemId() {
      return itemId;
   }

   public void setItemId(Integer itemId) {
      this.itemId = itemId;
   }

   public Sale getSale() {
      return sale;
   }

   public void setSale(Sale sale) {
      this.sale = sale;
   }

   public Item getItem() {
      return item;
   }

   public void setItem(Item item) {
      this.item = item;
   }

   public String getUpdateTime() {
      return updateTime;
   }

   public void setUpdateTime(String updateTime) {
      this.updateTime = updateTime;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public Integer getSaleDetailId() {
      return saleDetailId;
   }

   public void setSaleDetailId(Integer saleDetailId) {
      this.saleDetailId = saleDetailId;
   }
}