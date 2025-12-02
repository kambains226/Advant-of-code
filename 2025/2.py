def is_invalid_id(x: int) -> bool:
    s = str(x)
    n = len(s)

    # Try chunk lengths from 1 to half of the string
    for size in range(1, n):
        if n % size == 0:
            chunk = s[:size]
            if chunk * (n // size) == s:
                return True

    return False


total = 0

with open("2.txt", "r") as file:
    line = file.readline().strip()
    ranges = line.split(",")

for r in ranges:
    start, end = map(int, r.split("-"))
    for x in range(start, end + 1):
        if is_invalid_id(x):
            total += x

print(total)
