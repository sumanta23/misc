#!/usr/bin/python

import Tkinter
import tkMessageBox

top = Tkinter.Tk()
def hi():
tkMessageBox.showinfo("Dialogbox","my window")
t=Tkinter.Entry(top )
t.pack()
var ="ok"
b = Tkinter.Button( top, text=var, command=hi)


b.pack()

# Code to add widgets will go here...
top.mainloop()

