var quote = document.getElementById('quote');
var author = document.getElementById('author');
var btn = document.getElementById('btn');

var arr = [
  {
    quote: '늦었다고 생각할 때가 진짜 늦었다.',
    author: '박명수',
  },
  {
    quote: '내 죽음을 적에게 알리지 마라.',
    author: '이순신',
  },
  {
    quote:
      '일상적인 것을 포기할 용기가 없다면 당신은 영원히 평범하게 될 것이다.',
    author: '짐 론',
  },
  {
    quote: '아이들은 누구나 예술가이다.',
    author: '피카소',
  },
];

btn.addEventListener('click', function () {
  const randomN = Math.random() * arr.length;
  const SrcN = Math.floor(randomN);

  quote.textContent = arr[SrcN].quote;
  author.textContent = arr[SrcN].author;
});
