def large_two(line):
    digits = list(line)
    best = -1

    for i in range(len(digits) - 1):
        first = digits[i]
        second = max(digits[i + 1 :])
        value = int(first + second)
        best = max(best, value)

    return best


def large_12(line,k=12):
    stack = []
    to_pick = k

    for i, d in enumerate(line):
        remaining = len(line) - i

        while stack and stack[-1] < d and len(stack) - 1 + remaining >= to_pick:
            stack.pop()

        if len(stack) < to_pick:
            stack.append(d)

    return int("".join(stack))


with open("3.txt", "r") as file:
    count = 0
    for f in file:
        f = f.strip()

        count += large_12(f)
    print(count)
