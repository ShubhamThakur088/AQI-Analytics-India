The AQI-Analytics-India project conducts an analysis of AQI across major Indian cities of 29 states. It helps get insights about the AQIs and their statuses, such as Good, Satisfactory, Moderate, Poor, Very Poor and Severe, from year 2022 to 2025. Along with statuses, it helps identify the prominent pollutant.

To help understand the status of Air in a particular city, the air_quality_status column in XLSX file has been coloured as per the AQI varies. To understand how the colours have been assigned, please refer to the following website of CPCB:
- https://airquality.cpcb.gov.in/AQI_India/

 AQI Ranges and their Status:
 - 0 - 50 -> Good
 - 51 - 100 -> Satisfactory
 - 101 - 200 -> Moderate
 - 201 - 300 -> Poor
 - 301 - 400 -> Very Poor
 - 401 - 500 -> Severe

 # Tools used
 - MS Excel
 - Tableau
 - Pandas and Numpy (Python)
 - Draw DB Vercel


# AQI DB Schema Design

Further the data of Indian Cities' AQI is to be stored in to the DB, following Schema design can be followed. This design includes two tables. One table contains name of indian states and UTs (indian_states_uts) and second table contains aqi_values, aqi_status, day_of_record, area_name, state_id (FK) and prominent_pollutant
 <img width="967" height="481" alt="image" src="https://github.com/user-attachments/assets/a401f098-7cf4-4430-84a2-7d70437b3b4d" />

