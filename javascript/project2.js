var btn1 = document.getElementById('btn1');
var btn2 = document.getElementById('btn2');
var btn3 = document.getElementById('btn3');
var btn4 = document.getElementById('btn4');
var btn5 = document.getElementById('btn5');
var btn6 = document.getElementById('btn6');
var btn7 = document.getElementById('btn7');
var btn8 = document.getElementById('btn8');
var btn9 = document.getElementById('btn9');
var again = document.getElementById('again');
var li1 = document.getElementById('li1');
var li2 = document.getElementById('li2');
var li3 = document.getElementById('li3');
var li4 = document.getElementById('li4');
var li5 = document.getElementById('li5');
var record = document.getElementById('record');
var reset = document.getElementById('reset');

var randomS = ['O', 'X'];
var btnArr = [btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9];
var liArr = [li1, li2, li3, li4, li5];
var xNum = 0;

btn1.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn1.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn1.disabled = true;
});

btn2.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn2.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn2.disabled = true;
});

btn3.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn3.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn3.disabled = true;
});

btn4.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn4.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn4.disabled = true;
});

btn5.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn5.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn5.disabled = true;
});

btn6.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn6.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn6.disabled = true;
});

btn7.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn7.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn7.disabled = true;
});

btn8.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn8.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn8.disabled = true;
});

btn9.addEventListener('click', function () {
  const randomN = Math.random() * randomS.length;
  const SrcN = Math.floor(randomN);

  btn9.value = randomS[SrcN];

  if (randomS[SrcN] == 'X') {
    xNum++;
  }
  btn9.disabled = true;
});

again.addEventListener('click', function () {
  for (var i = 0; i < btnArr.length; i++) {
    btnArr[i].value = '?';
    btnArr[i].disabled = false;
  }
  xNum = 0;
});

var number = 0;

record.addEventListener('click', function () {
  if (number == liArr.length) {
    number = 0;
  }
  var name = prompt('');
  liArr[number].textContent = name + 'X 개수 : ' + xNum;

  number++;
});

reset.addEventListener('click', function () {
  for (var i = 0; i < liArr.length; i++) {
    liArr[i].textContent = 'None';
  }
});
