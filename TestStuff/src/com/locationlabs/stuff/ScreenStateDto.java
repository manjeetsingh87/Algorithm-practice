package com.locationlabs.stuff;

import java.util.Objects;

/**
 * Created by manjeet.singh on 9/25/18.
 */
public class ScreenStateDto {

   private Boolean screenOn;
   private Boolean screenOff;
   private Boolean noPasscode;
   private Boolean unavailable;

   public ScreenStateDto screenOn(Boolean screenOn) {
      this.screenOn = screenOn;
      return this;
   }

   public Boolean getScreenOn() {
      return screenOn;
   }

   public void setScreenOn(Boolean screenOn) {
      this.screenOn = screenOn;
   }

   public ScreenStateDto screenOff(Boolean screenOff) {
      this.screenOff = screenOff;
      return this;
   }

   public Boolean getScreenOff() {
      return screenOff;
   }

   public void setScreenOff(Boolean screenOff) {
      this.screenOff = screenOff;
   }

   public ScreenStateDto noPasscode(Boolean noPasscode) {
      this.noPasscode = noPasscode;
      return this;
   }

   public Boolean getNoPasscode() {
      return noPasscode;
   }

   public void setNoPasscode(Boolean noPasscode) {
      this.noPasscode = noPasscode;
   }

   public ScreenStateDto unavailable(Boolean unavailable) {
      this.unavailable = unavailable;
      return this;
   }

   public Boolean getUnavailable() {
      return unavailable;
   }

   public void setUnavailable(Boolean unavailable) {
      this.unavailable = unavailable;
   }


   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ScreenStateDto screenState = (ScreenStateDto) o;
      return Objects.equals(this.screenOn, screenState.screenOn) &&
              Objects.equals(this.screenOff, screenState.screenOff) &&
              Objects.equals(this.noPasscode, screenState.noPasscode) &&
              Objects.equals(this.unavailable, screenState.unavailable);
   }

   @Override
   public int hashCode() {
      return Objects.hash(screenOn, screenOff, noPasscode, unavailable);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ScreenStateDto {\n");

      sb.append("    screenOn: ").append(toIndentedString(screenOn)).append("\n");
      sb.append("    screenOff: ").append(toIndentedString(screenOff)).append("\n");
      sb.append("    noPasscode: ").append(toIndentedString(noPasscode)).append("\n");
      sb.append("    unavailable: ").append(toIndentedString(unavailable)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
   private String toIndentedString(java.lang.Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }

}
