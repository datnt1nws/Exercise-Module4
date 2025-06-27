<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Mail Configuration</title>
  <style>
    .container { width: 80%; margin: 20px auto; }
    .form-group { margin-bottom: 15px; }
    label { display: block; margin-bottom: 5px; }
    select, input { padding: 5px; width: 200px; }
    textarea { width: 100%; height: 100px; }
  </style>
</head>
<body>
<div class="container">
  <h2>Mail Configuration</h2>
  <form action="updateConfig" method="post">
    <div class="form-group">
      <label>Languages</label>
      <select name="language">
        <option ${config.language == 'English' ? 'selected' : ''}>English</option>
        <option ${config.language == 'Vietnamese' ? 'selected' : ''}>Vietnamese</option>
        <option ${config.language == 'Japanese' ? 'selected' : ''}>Japanese</option>
        <option ${config.language == 'Chinese' ? 'selected' : ''}>Chinese</option>
      </select>
    </div>
    <div class="form-group">
      <label>Page Size</label>
      <select name="pageSize">
        <option ${config.pageSize == 5 ? 'selected' : ''}>5</option>
        <option ${config.pageSize == 10 ? 'selected' : ''}>10</option>
        <option ${config.pageSize == 15 ? 'selected' : ''}>15</option>
        <option ${config.pageSize == 25 ? 'selected' : ''}>25</option>
        <option ${config.pageSize == 50 ? 'selected' : ''}>50</option>
        <option ${config.pageSize == 100 ? 'selected' : ''}>100</option>
      </select>
    </div>
    <div class="form-group">
      <label>Spam Filter</label>
      <input type="checkbox" name="spamFilter" ${config.spamFilter ? 'checked' : ''}>
    </div>
    <div class="form-group">
      <label>Signature</label>
      <textarea name="signature">${config.signature}</textarea>
    </div>
    <button type="submit">Update</button>
    <button type="button" onclick="window.location.href='/config'">Cancel</button>
  </form>
  <h3>Current Configuration</h3>
  <p>Language: ${config.language}</p>
  <p>Page Size: ${config.pageSize}</p>
  <p>Spam Filter: ${config.spamFilter ? 'Enabled' : 'Disabled'}</p>
  <p>Signature: ${config.signature}</p>
</div>
</body>
</html>