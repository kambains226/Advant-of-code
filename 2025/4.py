def part_two(grid: list[list[str]]) -> int:
    rows, cols = len(grid), len(grid[0])

    directions = [
        (-1, -1),
        (-1, 0),
        (-1, 1),
        (0, -1),
        (0, 1),
        (1, -1),
        (1, 0),
        (1, 1),
    ]

    def count_neighbors(r: int, c: int) -> int:
        cnt = 0
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == "@":
                cnt += 1
        return cnt

    total_removed = 0

    while True:
        to_remove: list[tuple[int, int]] = []

        # Find all currently accessible rolls
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] != "@":
                    continue
                if count_neighbors(r, c) < 4:
                    to_remove.append((r, c))

        # Stop if none can be removed
        if not to_remove:
            break

        # Remove them all at once
        for r, c in to_remove:
            grid[r][c] = "."

        total_removed += len(to_remove)

    return total_removed


def countNeibhbours(grid, row, col) -> int:
    directions = [
        (-1, 0),
        (-1, 1),
        (-1, -1),
        (0, -1),
        (0, 1),
        (1, 0),
        (1, 1),
        (1, -1),
    ]

    arr = [
        grid[row + dr][col + dc]
        for dr, dc in directions
        if 0 <= row + dr < len(grid) and 0 <= col + dc < len(grid[0])
    ]

    return sum(1 for n in arr if n == "@")


def grid_check(grid):
    count = 0
    for x in range(len(grid)):
        for y in range(len(grid[0])):
            cell = grid[x][y]
            if cell == "@":
                neighbours = countNeibhbours(grid, x, y)
                if neighbours < 4:
                    count += 1

    return count


with open("4.txt", "r") as file:
    grid = []
    for f in file:
        f = f.strip()
        temp = []

        for x in f:
            temp.append(x)

        grid.append(temp)


print(grid_check(grid))

print(part_two(grid))
