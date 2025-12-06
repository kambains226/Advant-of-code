
def parse_values(file_path):
    values = []
    with open(file_path, "r") as file:
        for line in file:
            line = line.strip()
            if line and "-" not in line:
                values.append(int(line))
    return values


def parse_ranges(file_path):
    ranges = []
    with open(file_path, "r") as file:
        for line in file:
            line = line.strip()
            if "-" in line:
                x, y = map(int, line.split("-"))
                ranges.append((x, y))
    return ranges


def part_one(values_file, ranges_file):
    values = parse_values(values_file)
    ranges = parse_ranges(ranges_file)

    seen = set()
    count = 0

    for v in values:
        for x, y in ranges:
            if x <= v <= y:
                if v not in seen:
                    seen.add(v)
                    count += 1
                break   # no need to check more ranges

    print("Part 1:", count)
    return count


def part_two(ranges_file):
    ranges = parse_ranges(ranges_file)
    ranges.sort()

    merged = []
    cur_start, cur_end = ranges[0]

    for start, end in ranges[1:]:
        if start <= cur_end + 1:  # overlaps or touches
            cur_end = max(cur_end, end)
        else:
            merged.append((cur_start, cur_end))
            cur_start, cur_end = start, end

    merged.append((cur_start, cur_end))

    total = sum((end - start + 1) for start, end in merged)

    print("Part 2:", total)
    return total


# Run both parts
part_one("5.txt", "5.txt")
part_two("5.txt")
