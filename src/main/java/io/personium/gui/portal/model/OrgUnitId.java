/**
 * Personium
 * Copyright 2016 FUJITSU LIMITED
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.personium.gui.portal.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * OrgUnitId class for mapping between organization and unit tables.
 */
@Embeddable
public class OrgUnitId implements Externalizable {
     /**
      * Constructor.
      */
     public OrgUnitId() {
     }

     private static final long serialVersionUID = 1L;

     @ManyToOne(targetEntity = Organization.class)
     private Organization organization;
     @ManyToOne(targetEntity = Unit.class)
     private Unit unit;
     /**
      * Get organization.
      * @return organization
      */
     public Organization getOrganization() {
          return organization;
     }
     /**
      * Set organization.
      * @param organization Organization
      */
     public void setOrganization(Organization organization) {
          this.organization = organization;
     }
     /**
      * Get unit.
      * @return unit
      */
     public Unit getUnit() {
          return unit;
     }
     /**
      * Set unit.
      * @param unit Unit
      */
     public void setUnit(Unit unit) {
          this.unit = unit;
     }

     /**
      * Overridden equals method.
      * @param o Object
      * @return true/false
      */
     public boolean equals(Object o) {
          if (this == o) {
               return true;
          }
          if (o == null || getClass() != o.getClass()) {
               return false;
          }
          OrgUnitId that = (OrgUnitId) o;
          boolean orgEqualCheck;
          if (organization != null) {
           orgEqualCheck = !organization.equals(that.organization);
          } else {
           orgEqualCheck = that.organization != null;
          }
          if (orgEqualCheck) {
               return false;
          }
          boolean unitEqualCheck;
          if (unit != null) {
           unitEqualCheck = !unit.equals(that.unit);
          } else {
           unitEqualCheck = that.unit != null;
          }
          if (unitEqualCheck) {
               return false;
          }
          return true;
     }
     /**
      * Overridden hashCode method.
      * @return result
      */
     public int hashCode() {
          int result = 0;
          if (organization != null) {
           result = organization.hashCode();
          }
          int hashCodeVal = 0;
          if (unit != null) {
           hashCodeVal = unit.hashCode();
          }
          final int multiplier = 31;
          result = multiplier * result + hashCodeVal;
          return result;
     }
     /**
      * The purpose of this function is to perform Serialization.
      * @param out ObjectOutput
      * @throws IOException exception
      */
     @Override
     public void writeExternal(ObjectOutput out) throws IOException {
     }
     /**
      * The purpose of this function is to perform Serialization.
      * @param in ObjectInput
      * @throws IOException exception
      * @throws ClassNotFoundException exception
      */
     @Override
     public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
     }
}
