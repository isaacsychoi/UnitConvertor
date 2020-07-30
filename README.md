# University of Ottawa - SEG2105 - Final Project - Mobile app design - Unit converter
# Author: Isaac Choi


**Background**: Most engineers would need to deal with different unit systems while solving engineering problems, in which they would need to convert values in one unit to another. For example, for purchasing pipes in the U.S. would require knowing the desired length and thickness in imperial units, such as inches and feet. On the other hand, within the metric system, the units used can also be different in different domain, such as blood pressure is measured in mmHg in biological system,  where the pressure in a chemical reactor is evaluated in Pascal (Pa) or kPa while there is a gas-phase reaction.

In engineering practice, length, flow rate, velocity, pressure, etc. are commonly measured in different devices with different unit systems. The intent of this software, *unit converter*, is to help engineers to convert different measured values to the values in the units that are desired in their workflow in a convenient and handy way. 

**Requirements** – User Stories:

1.	Convert a pressure value measured in mmHg to Pa
2.	Convert a pressure value measured in kPa to mmHg
3.	Convert a velocity value measured in m/s to kg/h
4.	Convert a velocity value measure in mi/h to m/s
5.	Convert a flow rate measured in ml/min to m3/s
6.	Convert a flow rate measured in ft3/s to ml/min
7.	Convert a length measured in m to inches
8.	Convert a length measured in feet to m

**Manual testing instruction:**

Disclaimer: Although this app is written in the Java language, the following test cases are only for running it on an Android device or an Android emulator (e.g. the one built-in Android Studio). The expected results that will be presented in this section are the results tested using an Android emulator. 

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Testcase 01:

System: Unit Convertor 

Lanuching the app

Severity: 1

Instructions:

1.    On Android Studio, press Run

Expected result:

1.   The app loads into the UI. One should observe 3 drop-down lists shown on top of the screen (one in orange, two in green), 2 text boxes in black background (i.e. screen), and numeric keypad (i.e. numpad) with operation buttons located below text boxes. The orange list should display with text: 'Click to select category:'. Shown in the image below. 

      [](images_test/AppLayout.png)


Cleanup:

1.   Close the app if not proceeding to test subsequent cases.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Test case 02:

System: Unit Convertor 

Select item from a drop-down list

Severity: 2

Instructions:

1.    If not proceeding from Testcase 01: On Android Studio, press Run (Testcase 01, instruction 1)
2.    Click on the orange drop-down list
3.    Select Pressure

Expected result:

1.   The text of the orange drop-down list should change to: 'Pressure'
2.   Each of the two green drop-down lists should display text: 'Click to select a unit':

 ![](images_test/TestCase02.png)
                                        


Cleanup:

1.   Close the app if not proceeding to test subsequent cases.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Test case 03:

System: Unit Convertor 

Select items from different drop-down lists

Severity: 2

Instructions:

1.    If not proceeding from Testcase 02: On Android Studio, press Run (Testcase 02, instruction 1)
2.    Click on the orange drop-down list and select pressure (Testcase 02. instructions 2 and 3)
3.    Click on the first green drop-down list and select Pa
4.    Similarly, click on the second green drop-down list and select kPa

Expected result:

1.   The text of the orange drop-down list should change to: 'Pressure'
2.   The text of the first green drop-down list should change to: 'Pa'
3.   The text of the second green drop-down list should change to: 'kPa'

 ![](images_test/TestCase03.png)


Cleanup:

1.   Close the app if not proceeding to test subsequent cases.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Test case 04:

System: Unit Convertor 

Test numeric keypad input

Severity: 2

Instructions:

1.    If not proceeding from Testcase 01: On Android Studio, press Run (Testcase 02, instruction 1)
2.    Using the numpad button located at the button of the screen, input 100 


Expected result:

1.    The first screen should display text: '100' in green colour


 ![](images_test/TestCase04.png)

Cleanup:

1.   Close the app if not proceeding to test subsequent cases.



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------


Test case 05:

System: Unit Convertor 

Test run button 

Severity: 2

Instructions:

1.    If not proceeding from Testcase 04: On Android Studio, press Run (Testcase 04, instruction 1)
2.    Using the numpad button located at the button of the screen, input 100 (Testcase 04, instruction 2)
3.    Press the purple 'RUN' button located at the bottom left of the screen


Expected result:

1.    The first screen should display text: '100' in green colour
2.    The second screen should display text: 'Please select a category first!'

 ![](images_test/TestCase05.png)

Cleanup:

1.   Close the app if not proceeding to test subsequent cases.



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Test case 06:

System: Unit Convertor 

Test converting pressure

Severity: 3

Instructions:

1.    If not proceeding from Testcase 03: On Android Studio, press Run (Testcase 03, instruction 1)
2.    Click on the orange drop-down list and select pressure (Testcase 03. instructions 2)
3.    Click on the first green drop-down list and select 'Pa' (Testcase 03. instructions 3)
4.    Similarly, click on the second green drop-down list and select 'kPa' (Testcase 03. instructions 4)
5.    Using the numpad to input '100' (Testcase 04, instruction 2)
6.    Press the purple 'RUN' button located at the bottom left of the screen (Testcase 05, instruction 3)

Expected result:

1.   The text of the orange drop-down list should change to: 'Pressure'
2.   The text of the first green drop-down list should change to: 'Pa'
3.   The text of the second green drop-down list should change to: 'kPa'
4.   The first screen should display text: '100' in green colour
5.   The second screen should display text: '0.1' in grey colour

 ![](images_test/TestCase06.png)

Cleanup:

1.   Close the app if not proceeding to test subsequent cases.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Test case 07:

System: Unit Convertor 

Test converting length

Severity: 3

Instructions:

1.    If not proceeding from Testcase 03: On Android Studio, press Run (Testcase 03, instruction 1)
2.    Click on the orange drop-down list and select 'Length' (Testcase 03. instructions 2)
3.    Click on the first green drop-down list and select 'm' (Testcase 03. instructions 3)
4.    Similarly, click on the second green drop-down list and select 'inch' (Testcase 03. instructions 4)
5.    Using the numpad to input '1' (Testcase 04, instruction 2)
6.    Press the purple 'RUN' button located at the bottom left of the screen (Testcase 05, instruction 3)

Expected result:

1.   The text of the orange drop-down list should change to: 'Length'
2.   The text of the first green drop-down list should change to: 'm'
3.   The text of the second green drop-down list should change to: 'inch'
4.   The first screen should display text: '1' in green colour
5.   The second screen should display text: '39.37' in grey colour

 ![](images_test/TestCase07.png)


Cleanup:

1.   Close the app if not proceeding to test subsequent cases.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Test case 08:

System: Unit Convertor 

Test converting velocity

Severity: 3

Instructions:

1.    If not proceeding from Testcase 03: On Android Studio, press Run (Testcase 03, instruction 1)
2.    Click on the orange drop-down list and select 'Velocity' (Testcase 03. instructions 2)
3.    Click on the first green drop-down list and select 'km/h' (Testcase 03. instructions 3)
4.    Similarly, click on the second green drop-down list and select 'm/s' (Testcase 03. instructions 4)
5.    Using the numpad to input '1' (Testcase 04, instruction 2)
6.    Press the purple 'RUN' button located at the bottom left of the screen (Testcase 05, instruction 3)

Expected result:

1.   The text of the orange drop-down list should change to: 'Velocity'
2.   The text of the first green drop-down list should change to: 'km/h'
3.   The text of the second green drop-down list should change to: 'm/s'
4.   The first screen should display text: '5' in green colour
5.   The second screen should display text: '1.38888889' in grey colour

 ![](images_test/TestCase08.png)

Cleanup:

1.   Close the app if not proceeding to test subsequent cases.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Test case 09:

System: Unit Convertor 

Test converting volumetric flow rate

Severity: 3

Instructions:

1.    If not proceeding from Testcase 03: On Android Studio, press Run (Testcase 03, instruction 1)
2.    Click on the orange drop-down list and select 'Volumetric flow rate' (Testcase 03. instructions 2)
3.    Click on the first green drop-down list and select 'm3/s' (Testcase 03. instructions 3)
4.    Similarly, click on the second green drop-down list and select 'L/min' (Testcase 03. instructions 4)
5.    Using the numpad to input '1' (Testcase 04, instruction 2)
6.    Press the purple 'RUN' button located at the bottom left of the screen (Testcase 05, instruction 3)

Expected result:

1.   The text of the orange drop-down list should change to: 'Volumetric flow rate'
2.   The text of the first green drop-down list should change to: 'm3/s'
3.   The text of the second green drop-down list should change to: 'L/min'
4.   The first screen should display text: '0.5' in green colour
5.   The second screen should display text: '30000.0' in grey colour

 ![](images_test/TestCase09.png)

Cleanup:

1.   Close the app if not proceeding to test subsequent cases.



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

