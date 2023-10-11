import sys

rows_num = int(input("\nВведіть розмір квадратної матриці: "))
filler = input("Введіть символ-заповнювач: ")

lst = []
mid = rows_num // 2
right = mid + 1

if len(filler) == 1:
    print()
    # Виведення на екран верхнього трикутника:
    for i in range(rows_num):
        if i < mid:
            row = []
            for j in range(i + 1):
                row.append(filler)
                print(row[-1], end=' ')
            lst.append(row)
            print()

        else:
            # Перехід до останньго символу "великого трикутника:
            for j in range(mid):
                print(' ', end=' ')

            # Виведення на екран нижнього трикутника:
            row = [' ' for _ in range(mid)]
            for j in range(mid, right):
                row.append(filler)
                print(row[-1], end=' ')
            right += 1
            lst.append(row)
            print()

else:
    if len(filler) == 0:
        print("Не введено символ-заповнювач")
        sys.exit(1)
    else:
        print("Забагато символів-заповнювачів")
        sys.exit(1)
