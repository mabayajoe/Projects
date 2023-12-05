from tkinter import Tk, Entry, Button, Label, font
from tkinter import messagebox

class Calculator:
    def __init__(self, root):
        self.root = root
        self.root.title("Calculaor")
        self.root.resizable(0, 0)

        self.create_widgets()

    def create_widgets(self):
        entry_font = font.Font(size=15)
        self.entry = Entry(self.root, justify="right", font=entry_font)
        self.entry.grid(row=0, column=0, columnspan=4, sticky='nsew', padx=5, pady=5)

        button_grid = [
            '7', '8', '9', '+',
            '4', '5', '6', '-',
            '1', '2', '3', '*',
            '0', '.', '/', '^'
        ]

        row, col = 1, 0
        for button_text in button_grid:
            self.create_button(button_text, row, col)
            col += 1
            if col > 3:
                col = 0
                row += 1

        self.create_button('<-', 1, 0, 2, self.handle_backspace)
        self.create_button('C', 1, 2, command=self.clear_entry)
        self.create_button('=', 5, 3, command=self.calculate)
        self.create_button('Quit', 6, 1, command=self.root.quit)

    def create_button(self, text, row, col, colspan=1, command=None):
        button = Button(self.root, text=text, padx=10, pady=3, command=lambda: self.handle_input(text, command))
        button.grid(row=row, column=col, columnspan=colspan, padx=5, pady=5, sticky='nsew')

    def handle_input(self, value, command):
        current_text = self.entry.get()
        if value == '=':
            self.calculate()
        elif command:
            command()
        else:
            self.entry.insert('end', value)

    def handle_backspace(self):
        current_text = self.entry.get()
        self.entry.delete(len(current_text) - 1)

    def clear_entry(self):
        self.entry.delete(0, 'end')

    def calculate(self):
        try:
            input_text = self.entry.get()
            result = str(eval(input_text))
            self.clear_entry()
            self.entry.insert('end', result)
        except Exception as e:
            messagebox.showerror("Error", f"Invalid expression: {str(e)}")

def main():
    root = Tk()
    calculator = Calculator(root)
    root.mainloop()

if __name__ == '__main__':
    main()
