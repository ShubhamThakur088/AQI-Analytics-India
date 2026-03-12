import pandas as pd

def read_xls_file(file_path):
    df = pd.read_excel(file_path, sheet_name='aqi')
    aqi_sheet_columns = df.columns

    states_set = set(df['state'])
    list_of_states = sorted(states_set)
    return list_of_states

def prepare_csv_file(list_of_states, file_path_csv):
    with open(file_path_csv, 'w') as file:
        file.write('states\n')
        for i in list_of_states:
            file.write(i+"\n")

  
file_path_xls = 'D:/CSV-Files/aqi-analytics-india/aqi_india.xlsx'
list_of_states = read_xls_file(file_path_xls)

file_path_csv = 'D:/CSV-Files/aqi-analytics-india/states_list.csv'
prepare_csv_file(list_of_states, file_path_csv)





# wb = excel_file_reading_obj.load_workbook(file_path)
# print(wb.sheetnames)