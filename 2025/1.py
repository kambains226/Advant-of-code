dial = 50


def count_hits_and_move(dial, direction, move):
    hits = 0
    for _ in range(move):
        if direction == "R":
            dial = (dial + 1) % 100
        else:  
            dial = (dial - 1) % 100

        if dial == 0:
            hits += 1

    return hits, dial


count = 0

with open("1.txt", "r") as file:
    for line in file:
        line = line.strip()
        direction = line[0]  # 'L' or 'R'
        move = int(line[1:])  # the number after it

        hits, dial = count_hits_and_move(dial, direction, move)
        count += hits

print(count, "count")

