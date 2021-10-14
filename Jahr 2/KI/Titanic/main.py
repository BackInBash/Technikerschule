import pandas as pd
import matplotlib.pyplot as plt


df = pd.read_csv('Titanic_891.csv')

for x in df.index:
  if df.loc[x, "Survived"] == 0:
    df.drop(x, inplace = True)

df.plot(x = 'Age')

plt.show()