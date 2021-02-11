# COVID-19 Swing

University project that uses Java Swing and MySql database, made using the Eclipse IDE.

OBS: This project uses the Portuguese language.

This project simulates a hospital in the middle of the COVID-19 pandemic that registers patients by name, id, gender, contamination sitiuation and age. 
The user can choose between 4 features:



-> Register:

  Here the user can register a patient, by name and if he/she was contaminated by the virus.
Depending the situation of the pacient, the info the user can put change:

  If the patient was not contaminated, the user must put their age.
  If the patient was contaminated, the user must only put their sitiuation:
  * Cured
  * Treating
  * Died
  
  After the patient is properly registered, his/her data goes to a MySql database (her/his id is 
automatically defined), that can be acessed within the program 
  (must run the script located in the "script" folder before starting the program for the first time).



-> List:
 
  Here the user can see all the patients that are registered in the database. Their info is showed in a table
and they are ordered by their ID. (1,2,3,...)



-> Look up by ID:
 
  Here the user can search specifically for a patient by its ID. If found, a pop-up will appear showin that patient's info.



-> Search:

  Here the user can search for one or more patients using part of the name or the whole name of him/her. The results will
 show up in a table, as in the 'List' feature.



 When the program is closed, the user will see a list of results showing the numbers of each kind of patient:
  * Not Contaminated
  * Patients in Treatment
  * Patients cured
  * Female patients that died
  * Male patients that died
  * Total of patients registered
  
  
