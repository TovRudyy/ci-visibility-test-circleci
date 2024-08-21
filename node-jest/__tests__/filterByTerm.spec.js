const filterByTerm = require("../src/filterByTerm");

function sleep(ms) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}

beforeEach(async () => {
});

afterEach(async () => {
});

beforeAll(async () => {
});

afterAll(async () => {
});

describe("Filter function", () => {
  test("it should filter by a search term (link)", async () => {
    const input = [
      { id: 1, url: "https://www.url1.dev" },
      { id: 2, url: "https://www.url2.dev" },
      { id: 3, url: "https://www.link3.dev" }
    ];

    const output = [{ id: 3, url: "https://www.link3.dev" }];

    await sleep(200);

    expect(filterByTerm(input, "link")).toEqual(output);

    expect(filterByTerm(input, "LINK")).toEqual(output);
  });

  test("it should filter by a search term (uRl)", () => {
    // solution ex 1
    const input = [
      { id: 1, url: "https://www.url1.dev" },
      { id: 2, url: "https://www.url2.dev" },
      { id: 3, url: "https://www.link3.dev" }
    ];

    const output = [
      { id: 1, url: "https://www.url1.dev" },
      { id: 2, url: "https://www.url2.dev" }
    ];

    expect(filterByTerm(input, "uRl")).toEqual(output);
  });

  test("it should throw when searchTerm is empty string", () => {
    // solution ex 2
    const input = [];
    expect(() => {
      filterByTerm(input, "");
    }).toThrowError(Error("searchTerm cannot be empty"));
  });


  test.skip("this test should be skipped", () => {
    // solution ex 2
    const input = [];
    expect(() => {
      filterByTerm(input, "");
    }).toThrowError(Error("searchTerm cannot be empty"));
  });
});
