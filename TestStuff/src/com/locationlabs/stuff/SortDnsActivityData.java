package com.locationlabs.stuff;

import java.util.List;


public class SortDnsActivityData {

   interface IDnsActivityFilterer {
      List addCategory(String data);

      List sortCategoriesByWeight(List data);

      List addDomain(String data);

      List sortDomainsByWeightedUsage(List data);
   }

   class DnsActivityFiltererImpl implements  IDnsActivityFilterer {

      @Override
      public List addCategory(String data) {
         return null;
      }

      @Override
      public List sortCategoriesByWeight(List data) {
         return null;
      }

      @Override
      public List addDomain(String data) {
         return null;
      }

      @Override
      public List sortDomainsByWeightedUsage(List data) {
         return null;
      }
   }

   class Category {
      private int id;
      private String name;

      Category(final int id, final String name) {
         this.id = id;
         this.name = name;
      }

      public int getId() {
         return id;
      }

      public void setId(int id) {
         this.id = id;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }
   }

   class Domain {
      private int id;
      private String name;
      private int categoryId;

      Domain(final int id, final String name, final int categoryId) {
         this.id = id;
         this.name = name;
         this.categoryId = categoryId;
      }

      public int getId() {
         return id;
      }

      public void setId(int id) {
         this.id = id;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }

      public int getCategoryId() {
         return categoryId;
      }

      public void setCategoryId(int categoryId) {
         this.categoryId = categoryId;
      }
   }
}
