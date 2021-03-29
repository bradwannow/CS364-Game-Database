import pandas as pd
import pyodbc
from sqlalchemy import create_engine

#read_data from Excel File
data = pd.read_csv (r'C:\Users\BJones\Desktop\vgsales-12-4-2019.csv')

#create a dataframe for each table we want
game_df = pd.DataFrame(data, columns = ['Rank', 'Name', 'Platform', 'Genre', 'Year'])
publisher_df = pd.DataFrame(data, columns = ['Rank', 'Publisher'])
developer_df = pd.DataFrame(data, columns = ['Rank', 'Developer'])
rating_df = pd.DataFrame(data, columns = ['Rank', 'ESRB_Rating', 'Critic_Score', 'User_Score'])
sales_df = pd.DataFrame(data, columns = ['Rank', 'Total_Shipped', 'Global_Sales', 'NA_Sales', 'PAL_Sales', 'JP_Sales', 'Other_Sales'])

#print to ensure correctness
print(game_df)
print(publisher_df)
print(developer_df)
print(rating_df)
print(sales_df)

#create the SQLite engine and connect to a database
engine = create_engine('sqlite:///testing2.db', echo=True)
sqlite_connection = engine.connect()

#create a table for each dataframe and add it to the database
game_table = "Game"
game_df.to_sql(game_table, sqlite_connection, if_exists='fail')

publisher_table = "Publisher"
publisher_df.to_sql(publisher_table, sqlite_connection, if_exists='fail')

developer_table = "Developer"
developer_df.to_sql(developer_table, sqlite_connection, if_exists='fail')

rating_table = "Rating"
rating_df.to_sql(rating_table, sqlite_connection, if_exists='fail')

sales_table = "Sales"
sales_df.to_sql(sales_table, sqlite_connection, if_exists='fail')

#close the connection
sqlite_connection.close()
