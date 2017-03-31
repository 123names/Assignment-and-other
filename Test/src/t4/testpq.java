package t4;

import java.util.PriorityQueue;
import java.util.Comparator;

public class testpq {
	public static void main(String[] args) {
	    PriorityQueue<Patient> patientQueue = new PriorityQueue<Patient>(1, new Comparator<Patient>() {
	    	public int compare(Patient step1,Patient step2){
	    		if (step1.getId()<step2.getId()){
	    			return -1;
	    		}
	    		else if (step1.getId()<step2.getId()){
	    			return 0;
	    		}
	    		else{
	    			return 1;
	    		}
	    	}
	    });
	
	    patientQueue.add(new Patient(3, "Patient1"));
	    patientQueue.add(new Patient(5, "Patient2"));
	    patientQueue.add(new Patient(9, "Patient3"));
	    patientQueue.add(new Patient(4, "Patient4"));
	    patientQueue.add(new Patient(5, "Patient5"));
	
	    System.out.println();
	    System.out.print("Doctor's waiting for patients  : ");
	    while(true) {
	        Patient currentPatient = patientQueue.poll();
	        if(currentPatient == null) {
	            break;
	        }
	
	        System.out.print(currentPatient.getName() + " <-- ");
	    }
	    System.out.println();
	}
}