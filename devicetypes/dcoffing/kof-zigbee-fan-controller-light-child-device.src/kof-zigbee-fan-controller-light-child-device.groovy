/**
 *  King Of Fans Zigbee Fan Controller - Light Child Device
 **
 *  Copyright 2017 Stephan Hackett
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "KOF Zigbee Fan Controller - Light Child Device", namespace: "dcoffing", author: "Stephan Hackett") {
		capability "Actuator"
        capability "Switch"
        capability "Switch Level"
        capability "Light"
        capability "Sensor" 
   }     


	tiles(scale: 2) { 		
        multiAttributeTile(name:"switch", type: "lighting", width: 6, height: 4, canChangeIcon: true) {
    		tileAttribute ("switch", key: "PRIMARY_CONTROL") {
        		attributeState "off", label:"off", action: "on", icon:"https://raw.githubusercontent.com/dcoffing/SmartThingsPublic/master/devicetypes/dcoffing/hampton-bay-universal-ceiling-fan-light-controller.src/Light175xfinal.png", backgroundColor: "#ffffff", nextState: "on"
				attributeState "on", label: "on", action: "off", icon:"https://raw.githubusercontent.com/dcoffing/SmartThingsPublic/master/devicetypes/dcoffing/hampton-bay-universal-ceiling-fan-light-controller.src/Light175xfinal.png", backgroundColor: "#00A0DC", nextState: "off"
        	}    	
    		tileAttribute ("device.level", key: "SLIDER_CONTROL") {
        		attributeState "level", action: "setLevel"
    		}
    	}
    
      valueTile("version", "version", width: 2, height: 2) {
    	state "version", label:"KOF Ceiling Fan"+"\r\n"+"Light Child Device"+"\r\r\n"+" Beta Version"+"\r\n"+"v0.2.1.20170419"+"\r\r\n"
		}  
      
    	main(["switch"])        
		details(["switch", "version"])    
    }
	
}


def on() {
	parent.lightOn()
	sendEvent(name: "switch", value: "on")
}

def off() {
	parent.lightOff()
    sendEvent(name: "switch", value: "off")
}

def setLevel(val) {
	parent.lightLevel(val)
    sendEvent(name: "level", value: val)
}
