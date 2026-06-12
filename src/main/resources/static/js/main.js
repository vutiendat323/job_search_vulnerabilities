/* JobSearch CTF — main.js */

/* ---- Active nav link ---- */
document.addEventListener('DOMContentLoaded', () => {
  const path = window.location.pathname;
  document.querySelectorAll('.nav-links a').forEach(a => {
    const href = a.getAttribute('href');
    if (href && href !== '/' && path.startsWith(href)) a.classList.add('active');
    else if (href === '/' && path === '/') a.classList.add('active');
  });

  /* ---- Typing effect on terminal lines ---- */
  const lines = document.querySelectorAll('.term-type');
  lines.forEach((el, i) => {
    const text = el.textContent;
    el.textContent = '';
    el.style.display = 'inline-block';
    setTimeout(() => {
      let j = 0;
      const iv = setInterval(() => {
        if (j < text.length) { el.textContent += text[j++]; }
        else clearInterval(iv);
      }, 28);
    }, i * 420);
  });

  /* ---- File input label ---- */
  const fileInputs = document.querySelectorAll('input[type="file"]');
  fileInputs.forEach(inp => {
    inp.addEventListener('change', () => {
      const label = inp.nextElementSibling;
      if (label && label.classList.contains('file-name')) {
        label.textContent = inp.files[0]?.name || 'No file chosen';
      }
      const drop = inp.closest('.upload-drop');
      if (drop && inp.files[0]) {
        drop.style.borderColor = 'var(--acc-green)';
      }
    });
  });

  /* ---- Glitch on logo click ---- */
  const brand = document.querySelector('.nav-brand');
  if (brand) {
    brand.addEventListener('click', (e) => {
      brand.style.animation = 'none';
      requestAnimationFrame(() => {
        brand.style.animation = 'glitch .4s ease-in-out';
        setTimeout(() => brand.style.animation = '', 400);
      });
    });
  }

  /* ---- Auto-dismiss alerts ---- */
  document.querySelectorAll('.alert-ok').forEach(el => {
    setTimeout(() => {
      el.style.transition = 'opacity .5s';
      el.style.opacity = '0';
      setTimeout(() => el.remove(), 500);
    }, 3500);
  });
});
