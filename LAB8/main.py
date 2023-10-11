import os
import struct
import sys
import math

#функція запису у ТЕКСТОВИЙ файл
def write_res_txt(f_name, result):
    with open(f_name, 'w') as f:
        f.write(str(result))
        print("Результат був записаний у текстовий файл!")

#функція читання з ТЕКСТОВОГО файлу
def read_res_txt(f_name):
    result = 0.0
    try:
        if os.path.exists(f_name):
            with open(f_name, 'r') as f:
                result = float(f.read())  #Перетворення зчитаного тексту у число
        else:
            raise FileNotFoundError(f"File {f_name} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

#функція запису у БІНАРНИЙ файл
def write_res_bin(f_name, result):
    with open(f_name, 'wb') as f:
        f.write(struct.pack('f', result))
        print("Результат був записаний у бінарний файл!")

#функція читання з БІНАРНОГО файлу
def read_res_bin(f_name):
    result = 0.0
    try:
        if os.path.exists(f_name):
            with open(f_name, 'rb') as f:
                result = struct.unpack('f', f.read())[0] #Перетворення зчитаних данних у float
        else:
            raise FileNotFoundError(f"File {f_name} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

#функція, яка виконує усі необхідні обчислення
def calculate_expression(x):
    try:
        result = math.tan(4 * x) / x
    except ZeroDivisionError:
        print("Ділення на нуль неможливе!")
        return None
    return result

#main функція програми:
if __name__ == "__main__":
    try:
        data = float(input("\nВведіть значення \"x\" [float]: "))
        result = calculate_expression(data)
        if result is not None:
            print(f"Результат обчислення виразу: {result}")
            print()
            write_res_txt("TextResult.txt", result)
            write_res_bin("BinaryResult.bin", result)
            print()
            print("Зчитаний результат з текстового файлу TextResult.txt: {0}".format(read_res_txt("TextResult.txt")))
            print("Зчитаний результат з бінарного файлу BinaryResult.bin: {0}".format(read_res_bin("BinaryResult.bin")))
    except ValueError as e:
        print(f"Error: {e}")
    except FileNotFoundError as e:
        print(e)
        sys.exit(1)
